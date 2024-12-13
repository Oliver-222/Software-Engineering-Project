package factorapi;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

import service.ComputationCoordinatorGrpc;
import service.CoordinatorService;

public class ComputationCoordinatorClient { // Boilerplate: changed to ComputationCoordinatorClient
    private final ComputationCoordinatorGrpc.ComputationCoordinatorBlockingStub blockingStub; // Boilerplate: updated to appropriate blocking stub

    public ComputationCoordinatorClient(Channel channel) {
        blockingStub = ComputationCoordinatorGrpc.newBlockingStub(channel);  // Boilerplate: updated to appropriate blocking stub
    }

    // Boilerplate: replaced this method with actual client call/response logic
    public void order() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your delimiter: ");
        String delimiter = sc.next();

        System.out.println("Enter your source: ");
        String source = sc.next();

        System.out.println("Enter your destination: ");
        String destination = sc.next();

        CoordinatorService.ComputeRequest computeRequest = CoordinatorService.ComputeRequest.newBuilder().setDelimiter(delimiter).setDestination(destination).setSource(source).build();
        CoordinatorService.ComputeResult response;
        try {
            response = blockingStub.compute(computeRequest);

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
        if (response.getStatus() == CoordinatorService.ComputeResultStatus.FAILURE){
            System.err.println("Error: " + response.getMessage());
        } else {
            System.out.println("Success: " + response.getStatus());
        }

        System.out.println("Would you like to see a visual? (Only will use the first input in your file)");
        System.out.println("Answer Y/N:");
        String choice = sc.next();
        if(choice.equals("Y")){
            try {
                response = blockingStub.computeSingle(computeRequest);
            } catch (StatusRuntimeException e) {
                e.printStackTrace();

            }
        } else if(choice.equals("N")){
            try {
                response = blockingStub.compute(computeRequest);
            } catch (StatusRuntimeException e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("Invalid input");
        }

    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50055";  // Boilerplate: made sure the server/port matches the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            ComputationCoordinatorClient client = new ComputationCoordinatorClient(channel); // Boilerplate: updated to this class name
            client.order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

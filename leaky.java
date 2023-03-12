import java.io.*;
import java.util.*;

class Leakingbucket {
    public static void main(String[] args) {
        int no_of_queries, storage, output_pkt_size;
        int input_pkt_size, bucket_size, size_left;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of queries: ");
        no_of_queries = sc.nextInt();

        System.out.print("Enter the bucket size: ");
        bucket_size = sc.nextInt();

        System.out.print("Enter the input packet size: ");
        input_pkt_size = sc.nextInt();

        System.out.print("Enter the output packet size: ");
        output_pkt_size = sc.nextInt();

        storage = 0;

        for (int i = 0; i < no_of_queries; i++) {
            size_left = bucket_size - storage; // space left

            if (input_pkt_size <= (size_left)) {
                storage += input_pkt_size;
            } else {
                System.out.println("Packet loss = " + input_pkt_size);
            }
            System.out.println("Buffer size= " + storage + " out of bucket size= " + bucket_size);
            storage -= output_pkt_size;
        }
    }
}

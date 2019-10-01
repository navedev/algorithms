package algo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class DateTesting {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Date: " + LocalDate.now());

		String inputString = "{\n" + "  \"GetSurroundingNodeList\": {\n" + "    \"ShipToAddress\": {\n"
				+ "      \"ZipCode\": \"60601\",\n" + "      \"Country\": \"US\"\n" + "    },\n"
				+ "    \"DistanceToConsiderUOM\": \"MILE\",\n" + "    \"NodeList\": [\n" + "      \"6737_9.0928\",\n"
				+ "      \"6741_73.7307\",\n" + "      \"702_0.0\",\n" + "      \"888_0.0\"\n" + "    ],\n"
				+ "    \"NodeType\": \"Store\",\n" + "    \"OrganizationCode\": \"LOWES\",\n"
				+ "    \"DistanceToConsider\": \"75.00\",\n" + "    \"FulfillmentType\": \" \"\n" + "  }\n" + "}";

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject(inputString);
		byte b[] = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(b);
		ObjectInput in = new ObjectInputStream(bis);

		String outputString = (String) in.readObject();

		System.out.println(outputString);
	}

}

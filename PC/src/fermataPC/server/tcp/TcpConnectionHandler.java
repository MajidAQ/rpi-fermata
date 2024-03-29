package fermataPC.server.tcp;

import java.io.*;
import java.net.*;
import java.util.*;

public class TcpConnectionHandler implements Runnable
{

	public Vector<Thread> threads = new Vector<Thread>();
	
	private String[] inbound;
	private String[] outbound;
	private int port;
	private String greetingMessage;

	public TcpConnectionHandler(int port, String[] inbound2, String[] outbound2, String greetingMessage)
	{
		this.inbound = inbound2;
		this.outbound = outbound2;
		this.port = 9876;
		this.greetingMessage = greetingMessage;
	}

	@Override
	public void run() 
	{
		System.out.println("TCP Server Started - Listening on port: " + port);
		try
		{
			//Create a listener socket
			ServerSocket serverSocket = new ServerSocket(port);

			while(true)
			{
				// Listen for a connection request
				System.out.println("TCP Server waiting for connection...");
				Socket socket = serverSocket.accept();

				System.out.println("TCP Server accepted connection");
				//Spawn a new threadHandler to handle the thread
				TcpConnectionProcessor TcpConnectionProcessor = new TcpConnectionProcessor(socket, inbound, outbound, greetingMessage);
				Thread thread = new Thread(TcpConnectionProcessor);
				threads.add(thread);
				thread.start();
			}
		}
		catch ( IOException ex )
		{
			System.err.println( ex );
		}
	}
}


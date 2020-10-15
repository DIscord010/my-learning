package club.csiqu.learn.concurrent.mock.server;

import club.csiqu.learn.concurrent.mock.server.command.BaseCommand;
import club.csiqu.learn.concurrent.mock.server.command.ErrorCommand;
import club.csiqu.learn.concurrent.mock.server.command.QueryCommand;
import club.csiqu.learn.concurrent.mock.server.command.ReportCommand;
import club.csiqu.learn.concurrent.mock.server.command.StopCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Siqu Chen 2020/8/14
 * @since 1.0
 */
public class ConcurrentServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentServer.class);

    private boolean stopServer = false;

    public void service() {
        LOGGER.info("Server begin service in port: {}.", Constants.SERVER_PORT);
        try (ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT)) {
            do {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String line = in.readLine();
                    String[] commandData = line.split(" ");
                    BaseCommand command;
                    LOGGER.info("Request command is: [{}].", commandData[0]);
                    switch (commandData[0]) {
                        case "q":
                            command = new QueryCommand(commandData);
                            break;
                        case "r":
                            command = new ReportCommand(commandData);
                            break;
                        case "z":
                            command = new StopCommand(commandData);
                            stopServer = true;
                            break;
                        default:
                            command = new ErrorCommand(commandData);
                            LOGGER.warn("Request command: {} error.", commandData[0]);
                    }
                    String response = command.execute();
                    out.println(response);
                    out.flush();
                }
            }
            while (!stopServer);
            LOGGER.info("Server stop.");
        } catch (IOException ioException) {
            LOGGER.warn("Start server error：{}", ioException.getMessage());
        }
    }
}
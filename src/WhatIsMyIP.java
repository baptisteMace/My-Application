
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/WhatIsMyIP")
public class WhatIsMyIP {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() throws UnknownHostException {

        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("System IP Address : " +
                (localhost.getHostAddress()).trim());

        // Find public IP address
        String systemIpAddress = "";
        try
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");

            BufferedReader sc =
                    new BufferedReader(new InputStreamReader(url_name.openStream()));

            // reads system IPAddress
            systemIpAddress = sc.readLine().trim();
        }
        catch (Exception e)
        {
            systemIpAddress = "Cannot Execute Properly";
        }
        return systemIpAddress;
    }
}

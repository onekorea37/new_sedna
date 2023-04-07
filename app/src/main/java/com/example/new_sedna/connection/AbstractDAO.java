package com.example.new_sedna.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AbstractDAO {

    private Connection connection;

    // For Amazon Postgresql
    // private final String host = "sednadb.coa7viwdlyc8.us-east-2.rds.amazonaws.com"

    private final String host = "sednadb.coa7viwdlyc8.us-east-2.rds.amazonaws.com";
    private final String database = "sednadb"; // postgres
    private final int port = 5432;
    private final String user = "teamsedna";
    private final String pass = "password";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;
    //https://docs.aws.amazon.com/ko_kr/AmazonRDS/latest/AuroraUserGuide/UsingWithRDS.IAMDBAuth.Connecting.AWSCLI.PostgreSQL.html


    public AbstractDAO()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }
}

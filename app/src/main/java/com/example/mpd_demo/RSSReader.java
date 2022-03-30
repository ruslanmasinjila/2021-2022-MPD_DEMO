package com.example.mpd_demo;

import java.net.*;
import java.io.*;

public class RSSReader
{
    private String urlString = "http://m.highwaysengland.co.uk/feeds/rss/AllEvents.xml";
    private String rssString = "";
    int numLines = 1000;




    public void FetchRSS()
    {
        try
        {
            URL url = new URL(urlString);
            URLConnection conn = (URLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            int counter = 0;

            while ((inputLine = in .readLine()) != null)
            {
                if(counter<numLines)
                {
                    rssString += inputLine;
                    counter++;
                }
            }

            PrintWriter out = new PrintWriter("filename.txt");
            out.println(rssString);
            in .close();

        }

        catch (Exception e)

        {
            System.out.println(e.toString());
        }

    }

    public String getRSSString()
    {
        return rssString;
    }


}
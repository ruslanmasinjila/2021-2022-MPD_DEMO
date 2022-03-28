package com.example.mpd_demo;

import java.net.*;
import java.io.*;

public class RSSReader
{
    private String urlString = "https://m.highwaysengland.co.uk/feeds/rss/UnplannedEvents.xml";
    private String rssString = "";



    public void FetchRSS()
    {
        try
        {
            URL url = new URL(urlString);
            URLConnection conn = (URLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            while ((inputLine = in .readLine()) != null)
            {
                rssString += inputLine;
            }
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
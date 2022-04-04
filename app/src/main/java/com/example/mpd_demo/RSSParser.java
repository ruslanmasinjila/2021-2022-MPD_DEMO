package com.example.mpd_demo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;


public class RSSParser
{

    LinkedList <Incident> incidentList = null;


    LinkedList <String>  titleList = null;


    public LinkedList<Incident> parseRSSString(String rssString)
    {
        Incident incident = null;

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput( new StringReader( rssString ) );
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT)
            {

                // Found a start tag
                if(eventType == XmlPullParser.START_TAG)
                {
                    // Check which Tag we have
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        incidentList = new LinkedList<Incident>();
                        titleList     = new LinkedList<String>();


                        for(int i = 0; i<30; i++)
                        {
                            eventType = xpp.next();

                        }

                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        incident = new Incident();
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("title"))
                    {
                        // Now just get the associated text
                        String temp = xpp.nextText();
                        incident.setTitle(temp);

                    }
                    else
                        if (xpp.getName().equalsIgnoreCase("category"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setCategory(temp);
                        }
                        else if (xpp.getName().equalsIgnoreCase("severity"))
                            {
                                // Now just get the associated text
                                String temp = xpp.nextText();
                                incident.setSeverity(temp);
                            }
                        else if (xpp.getName().equalsIgnoreCase("description"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setDescription(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("road"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setRoad(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("region"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setRegion(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("latitude"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setLatitude(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("longitude"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setLongitude(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("eventStart"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setEventStart(temp);
                        }

                        else if (xpp.getName().equalsIgnoreCase("eventEnd"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            incident.setEventEnd(temp);
                        }


                }
                else
                if(eventType == XmlPullParser.END_TAG)
                {
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        incidentList.add(incident);
                        titleList.add(incident.getTitle());
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        int size;
                        size = incidentList.size();
                    }
                }

                // Get the next event
                eventType = xpp.next();
            }

        }

        catch (XmlPullParserException e)
        {
            System.out.println("Parsing Error "+e.toString());
        }

        catch (IOException e)
        {
            System.out.println("Parsing Error "+e.toString());
        }
        return incidentList;
    }

    // THE END
}
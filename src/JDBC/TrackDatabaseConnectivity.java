package JDBC;

import GUIinterface.LoginModule;
import java.io.*;
import java.net.*;
import java.sql.*;

class downloadFromURL {

    public static void download(String URL, String downloadLocation, String trackName) {
        try {
            downloadUsingStream(URL, downloadLocation + "\\" + trackName + ".mp3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

}

public class TrackDatabaseConnectivity {

    static ResultSet rs;

    public static String getURL(String Title, String Album) {
        DataRetrieve dr = new DataRetrieve();
        try {
            rs = dr.stmt.executeQuery("SELECT `URL` FROM `TrackDatabase` WHERE Title LIKE '" + Title + "' AND Album LIKE '" + Album + "'");
            
            if (rs.next()) {
                return rs.getString("URL");
            }
            dr.stmt.close();
        } catch (SQLException ex) {

        }
        return null;
    }

    public static boolean downloadTrack(String URL) {
        DataRetrieve dr = new DataRetrieve();
        try {
            rs = dr.stmt.executeQuery("SELECT `URL`,`Title` FROM `TrackDatabase` WHERE URL = '" + URL + "'");
            
            if (rs.next()) {
                downloadFromURL.download(URL, LoginModule.DownloadLocation, rs.getString("Title"));
                return true;
            }
            dr.stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet runQuery(String query) {
        DataRetrieve dr = new DataRetrieve();

        try {
            rs = dr.stmt.executeQuery(query);
        } catch (SQLException ex) {
        }
        return rs;
    }

    public static void increaseView(String URL) {
        try {
            DataRetrieve dr = new DataRetrieve();
            rs = dr.stmt.executeQuery("SELECT * FROM `TrackDatabase` WHERE URL = '" + URL + "'");
            if (rs.next()) {
                long view = rs.getLong("Views");

                dr.pstmt = dr.con.prepareStatement("UPDATE `TrackDatabase` SET `Views` = ? WHERE URL = '" + URL + "'");
                dr.pstmt.setLong(1, view + 1);
                dr.pstmt.executeUpdate();
                dr.pstmt.close();
                dr.con.close();
            }
        } catch (SQLException ex) {
        }
    }
}

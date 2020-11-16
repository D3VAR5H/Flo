package JDBC;

import GUIinterface.LoginModule;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;

// User details management
public class UserDatabaseConnectivity {

    static ResultSet rs;

    // Authenticating login info of the user 
    public static boolean LoginAuthentication(String EmailUsername, String Password) {
        try {
            DataRetrieve dr = new DataRetrieve();
            Password = passwordHash.getHash(Password);
            rs = dr.stmt.executeQuery("SELECT * FROM `UserDatabase` WHERE (Username='" + EmailUsername + "' OR EmailID='" + EmailUsername + "') AND Password='" + Password + "'");
            if (rs.next()) {

                LoginModule.DownloadLocation = rs.getString("DownloadLocation");
                LoginModule.Username = rs.getString("Username");
                LoginModule.UserID = rs.getInt("UserID");

                dr.con.close();
                dr.stmt.close();
                return true;
            } else {
                dr.con.close();
                dr.stmt.close();
                return false;
            }
        } catch (SQLException ex) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    // Creating new account
    public static boolean CreateAccount(String Username, String EmailID, String Password) {
        try {
            DataRetrieve dr = new DataRetrieve();
            Password = passwordHash.getHash(Password);

            dr.pstmt = dr.con.prepareStatement("INSERT INTO  `UserDatabase` (`Username`, `EmailID`, `Password`) VALUES (?,?,?)");
            dr.pstmt.setString(1, Username);
            dr.pstmt.setString(2, EmailID);
            dr.pstmt.setString(3, Password);
            int i = dr.pstmt.executeUpdate();
            if (i > 0) {

                rs = dr.stmt.executeQuery("SELECT * FROM `UserDatabase` WHERE Username='" + Username + "' AND EmailID='" + EmailID + "' AND Password='" + Password + "'");
                if (rs.next()) {
                    LoginModule.DownloadLocation = rs.getString("DownloadLocation");
                    LoginModule.Username = Username;
                    LoginModule.UserID = rs.getInt("UserID");
                }

                dr.pstmt.close();
                dr.con.close();
                return true;
            } else {
                dr.pstmt.close();
                dr.con.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR", "Check your Internet Connection.", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    // Check whether the user alredy exists on the basis of Email Id
    public static boolean CheckExistence(String Username, String EmailID) {
        try {
            DataRetrieve dr = new DataRetrieve();

            int cnt = 0;
            rs = dr.stmt.executeQuery("SELECT * FROM `UserDatabase` WHERE `EmailID` ='" + EmailID + "' OR `Username` = '" + Username + "'");
            while(rs.next()) {
                cnt++;
            }
            if (cnt > 0) {
                dr.stmt.close();
                dr.con.close();
                return true;
            } else {
                dr.stmt.close();
                dr.con.close();
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return true;
        }

    }

    //Update Download Location Existing Account
    public static void updateDownloadLocation(File f, int UserID) {
        try {
            DataRetrieve dr = new DataRetrieve();
            dr.pstmt = dr.con.prepareStatement("UPDATE `UserDatabase` SET `DownloadLocation` = ? WHERE UserID = '" + UserID + "'");
            dr.pstmt.setString(1, f.getAbsolutePath());
            dr.pstmt.executeUpdate();
            
            dr.pstmt.close();
            dr.con.close();
        } catch (SQLException ex) {
        }
    }
}

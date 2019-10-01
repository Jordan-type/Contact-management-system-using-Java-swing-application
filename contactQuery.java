package cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JORDAN TYPE
 */
public class contactQuery {

    public void insertContact(fContact cont) {

        Connection conn = Myconnection.getConnection();
        PreparedStatement ps;

        try {

            ps = conn.prepareStatement("INSERT INTO `cms_contacts`(`firstname`, `lastname`, `groupc`, `phone`, `email`, `address`, `image`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getGroup());
            ps.setString(4, cont.getPhone());
            ps.setString(5, cont.getEmail());
            ps.setString(6, cont.getAddress());
            ps.setBytes(7, cont.getPic());
            ps.setInt(8, cont.getUid());

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact Added Successfuly!");

            } else {
                JOptionPane.showMessageDialog(null, "Unable To Add Contact");

            }
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // update
    public void updateContact(fContact cont, boolean withImage) {

        Connection conn = Myconnection.getConnection();
        PreparedStatement ps;
        String UpdateQuery = "";

        if (withImage == true) // if the user want to update the contact profile picture too
        {

            UpdateQuery = "UPDATE `cms_contacts` SET `id`= ?,`firstname`= ?,`lastname`= ?,`groupc`= ?,`phone`= ?,`email`= ?,`address`= ?,`image`= ? WHERE `id`= ?";

            try {

                ps = conn.prepareStatement(UpdateQuery);
                ps.setString(1, cont.getFname());
                ps.setString(2, cont.getLname());
                ps.setString(3, cont.getGroup());
                ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                ps.setString(6, cont.getAddress());
                ps.setBytes(7, cont.getPic());
                ps.setInt(8, cont.getCid());

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Data Edited Successfuly !");

                } else {
                    JOptionPane.showMessageDialog(null, "Unable To Edit Contact !");

                }
            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {// if the user want to keep the same image[ remove the image from the update]

            UpdateQuery = "UPDATE `cms_contacts` SET `id`= ?,`firstname`= ?,`lastname`= ?,`groupc`= ?,`phone`= ?,`email`= ?,`address`= ? WHERE `id`= ?";

            try {

                ps = conn.prepareStatement(UpdateQuery);
                ps.setString(1, cont.getFname());
                ps.setString(2, cont.getLname());
                ps.setString(3, cont.getGroup());
                ps.setString(4, cont.getPhone());
                ps.setString(5, cont.getEmail());
                ps.setString(6, cont.getAddress());
                ps.setInt(7, cont.getCid());

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Contact Data Edited Successfuly !");

                } else {
                    JOptionPane.showMessageDialog(null, "Unable To Edit Contact !");

                }
            } catch (SQLException ex) {
                Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    // Delete
     public void deleteContact(int cid) {

        Connection conn = Myconnection.getConnection();
        PreparedStatement ps;

        try {

            ps = conn.prepareStatement("DELETE FROM `cms_contacts` WHERE `id` = ?");
            ps.setInt(1, cid);

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact Deleted Successfuly!");

            } else {
                JOptionPane.showMessageDialog(null, "Unable To Delete Contact");

            }
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Create a List of contact
    public ArrayList<fContact> contactList(int userId) {
        ArrayList<fContact> clist = new ArrayList<fContact>();

        Connection conn = Myconnection.getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT `id`, `firstname`, `lastname`, `groupc`, `phone`, `email`, `address`, `image`, `userid` FROM `cms_contacts` Where userid ="+userId);

            fContact ct;

            while (rs.next()) {

                ct = new fContact(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("groupc"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("image"),
                        userId);

                clist.add(ct);

            }

        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clist;

    }

}

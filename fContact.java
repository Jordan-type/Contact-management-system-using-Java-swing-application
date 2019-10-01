package cms;

/**
 *
 * @author JORDAN TYPE
 */
public class fContact {
    private Integer cid;
    private String fname;
    private String lname;
    private String group;
    private String phone;
    private String email;
    private String address;
    private byte[] pic;
    private int uid;
    
    //Alt + ins
    //to generate constractor & getters & setters

    public fContact() {}
    
    

    public fContact(Integer cid, String fname, String lname, String group, String phone, String email, String address, byte[] pic, int uid) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.group = group;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pic = pic;
        this.uid = uid;
    }

    fContact(int i, String fname, String lname, String groupc, String phone, String address, byte[] img, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
    
    
    
}

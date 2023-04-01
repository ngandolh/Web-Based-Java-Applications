/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customtag;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Asus
 */
public class VNCurrentDate extends SimpleTagSupport {
    public void doTag() throws JspException, IOException{
        JspWriter out = getJspContext().getOut();
        Date date = new Date();
        out.println("Date " + date.toString());
    }
}

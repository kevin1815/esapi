package com.shuyun.ccms;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

public class AppTest {

    public static void main(String[] args) {
        String input1 = "用户输入1";
        String input2 = "用户输入2";
        //解决注入问题
        input1 = ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), input1);
        input2 = ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), input2);
        String sqlStr = "SELECT name FROM table WHERE id = " + input1 + " AND date_created = '" + input2 + "'";
        System.out.println(sqlStr);
        System.out.println(ESAPI.encoder().encodeForHTML("<a href='sdfs'></a> < script > alert(); </ script >"));
    }
}

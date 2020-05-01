package com.jmt.mascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Properties;

public class Contacto extends AppCompatActivity {

    EditText correo;
    EditText mensaje;
    EditText nombre;
    Button send;
    Session sesion;
    String user;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        actionBar();
        enviarcorreo();

    }

    public void enviarcorreo(){
    correo =(EditText) findViewById(R.id.emailIn);
    mensaje = (EditText) findViewById(R.id.contentIn);
    nombre = (EditText) findViewById(R.id.nombreIn);
    send = (Button) findViewById(R.id.sendButton);

    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            user = "jmsenderr@gmail.com";
            pass = "Velero2020";
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Enviando mensaje espere...", Toast.LENGTH_LONG);
            toast1.show();
            StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "465");


            try {
                sesion = Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,pass);
                    }
                });
                if (sesion != null){
                    Message message = new MimeMessage(sesion);
                    message.setFrom(new InternetAddress(user));
                    message.setSubject("Facil");
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("jmter@outlook.com"));
                    message.setContent(mensaje.getText().toString(),"text/html; charset=utf-8");
                    Transport.send(message);

                    Toast toast3 =
                            Toast.makeText(getApplicationContext(),"Mensaje enviado",Toast.LENGTH_LONG);
                    toast3.show();

                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                "Error de envio", Toast.LENGTH_SHORT);
                toast2.show();
            }

        }
    });
    }
    public void actionBar(){
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}

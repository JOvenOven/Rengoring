package com.example.rengoring;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.1.66/Rengoring/pruebaRegistro.php";
        String login_url = "http://192.168.1.66/Rengoring/login.php";
        //String reg_url = "http://192.168.20.157/Rengoring/registrarUsuario.php";
        //String login_url = "http://192.168.20.157/Rengoring/login.php";

        //String reg_url = "http://10.0.2.2/webapp/register.php";
        //String login_url = "http://10.0.2.2/webapp/login.php";
        String method = params[0];
        if (method.equals("register")) {
            String nombre = params[1];
            String usuario = params[2];
            String pass = params[3];
            String correo=params[4];
            String fecnac=params[5];
            String text=params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(nombre, "UTF-8") + "&" +
                        URLEncoder.encode("usuario", "UTF-8") + "=" + URLEncoder.encode(usuario, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&" +
                        URLEncoder.encode("correo", "UTF-8") + "=" + URLEncoder.encode(correo, "UTF-8") + "&" +
                        URLEncoder.encode("fecnac", "UTF-8") + "=" + URLEncoder.encode(fecnac, "UTF-8") + "&" +
                        URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(text, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Registration Success...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login"))
        {
            String login_correo = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_correo","UTF-8")+"="+URLEncoder.encode(login_correo,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("agregarRes")){

            String cantidad = params[1];
            String residuo = params[2];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("cantidad", "UTF-8") + "=" + URLEncoder.encode(cantidad, "UTF-8") + "&" +
                        URLEncoder.encode("residuo", "UTF-8") + "=" + URLEncoder.encode(residuo, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Agregado correctamente...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
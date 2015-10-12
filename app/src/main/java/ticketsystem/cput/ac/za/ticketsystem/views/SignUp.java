package ticketsystem.cput.ac.za.ticketsystem.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import ticketsystem.cput.ac.za.ticketsystem.R;
import ticketsystem.cput.ac.za.ticketsystem.model.Admin;
import ticketsystem.cput.ac.za.ticketsystem.model.FullName;
import ticketsystem.cput.ac.za.ticketsystem.model.Login;
import ticketsystem.cput.ac.za.ticketsystem.services.AdminServices;
import ticketsystem.cput.ac.za.ticketsystem.services.Impl.AdminServicesImpl;

public class SignUp extends Activity {//extends AppCompatActivity {

    String userExists = "";
    private Button signUp;
    private Button cancel;
    private EditText email;
    private EditText password;
    private EditText firstname;
    private EditText lastname;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
create();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void create(){
        email = (EditText)findViewById(R.id.txtEmail);
        password = (EditText)findViewById(R.id.txtPassword);
        firstname = (EditText)findViewById(R.id.txtFN);
        lastname = (EditText)findViewById(R.id.txtLastname);
        signUp = (Button)findViewById(R.id.btnSignup2);
        cancel = (Button)findViewById(R.id.btnCancel);
        scrollView = (ScrollView)findViewById(R.id.scrollView2);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        signUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(email.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    email.requestFocus();
                    email.setError("Cannot be empty.");
                }else if(password.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    password.requestFocus();
                    password.setError("Cannot be empty.");
                }else if(firstname.getText().toString().equals(""))
                {
                    scrollView.scrollTo(0, 0);
                    firstname.requestFocus();
                    firstname.setError("Cannot be empty.");
                }else {
                    if(lastname.getText().toString().equals(""))
                    {
                        scrollView.scrollTo(0, 0);
                        lastname.requestFocus();
                        lastname.setError("Cannot be empty.");
                    }
                    else {
                        Thread thread = new Thread(new Runnable() {

                            @Override
                            public void run() {

                                AdminServicesImpl service = new AdminServicesImpl();

                                Admin admin = new Admin(new Login(email.getText().toString(),password.getText().toString()),new FullName(firstname.getText().toString(), lastname.getText().toString()));
                                //admin.setLoginDeats(new Login(email.getText().toString(), password.getText().toString()));
                               //admin.setFullNameDeats(new FullName(firstname.getText().toString(), lastname.getText().toString()));


                               userExists = service.addAdmin(admin);
                            }
                        });

                        thread.start();

                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (userExists==null) {
                            //Go to Login page, send username to txtLoginUsername

                            Intent openStep = new Intent(SignUp.this, MainActivity.class);
                            //openStep.putExtra("FirstName", firstName.getText().toString());
                          //  finish();
                            startActivity(openStep);

                        }
                        else {
                            scrollView.scrollTo(0, 0);
                            System.out.println("This error is here");
                        }
                    }
                }

            }
        });
    }
}







  /*private Button signUp;
    private Button cancel;
    private EditText email;
    private EditText password;
    private EditText firstname;
    private EditText lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        firstname = (EditText) findViewById(R.id.txtFN);
        lastname = (EditText) findViewById(R.id.txtLastname);

        signUp = (Button) findViewById(R.id.btnSignup);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        AdminServices service = new AdminServicesImpl();

                        Login loginDetails = new Login();
                        FullName fnDetails = new FullName();

                        Admin admin = new Admin();

                        loginDetails.setLoginEmail("tester");
                        loginDetails.setPassword("tester");
                        fnDetails.setFirstname("tester");
                        fnDetails.setLastname("tester");

                        admin.setLoginDeats(loginDetails);
                        admin.setFullNameDeats(fnDetails);

                        service.addAdmin(admin);
                    }
                });

                thread.start();

                try {

                    thread.join();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                startActivity(new Intent(SignUp.this, MainActivity.class));

            }
        });

        cancel = (Button)findViewById(R.id.btnCancel);

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,MainActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

*/
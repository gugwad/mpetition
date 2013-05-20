/**
 *Developer : Ashwith Raj A (developer.expie00102@gmail.com)
 * Date : 07/05/2013
 * All code (c)2013 Experinn solutions inc. all rights reserved
 */

package in.xperinn.mpetition;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayPetitionActivity extends Activity {
    private String passAnswer;
    MediaPlayer player;
    final Context context = this;
    public String getPassAnswer() {
        return passAnswer;
    }

    public void setPassAnswer(String passAnswer) {
        this.passAnswer = passAnswer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_petition);
        //code for playing music in backround
        player = MediaPlayer.create(PlayPetitionActivity.this, R.raw.home);
        player.setLooping(true);
        try {
            player.prepare();
        } catch (IllegalStateException e) {            
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();

        //event to hiden text which stores the answer and changes the focus to 
        //petition textfield

        EditText hidentext = (EditText)findViewById(R.id.hidentext);
        hidentext.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //stores the answer in string and changes the focus to second activity
                if (event.getAction() == KeyEvent.ACTION_DOWN)

                    if(keyCode == KeyEvent.KEYCODE_COMMA){
                        EditText petitiontext = (EditText)findViewById(R.id.petitiontext); 
                        petitiontext.requestFocus();
                        return true;
                        
                    }
                return false;
            }
        });


        addListenerOnButton();
    }
    private void addListenerOnButton() {
        //  Button  b2= (Button) findViewById(R.id.send);
        final EditText hidentext =(EditText)findViewById(R.id.hidentext);
        hidentext.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        hidentext.addTextChangedListener(new TextWatcher() {

            // operation to display the petition question in the pettiton, after 
            // you press comma and writing the actual answer
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int lengthOfanswer = hidentext.getText().toString().length();

                EditText petition = (EditText)findViewById(R.id.petitiontext);
               
                for(int i=0;i<lengthOfanswer;i++)
                {
                    String append = petition.getText().toString();
                    petition.setText(append);
                    if(i == 0){
                    petition.setText("p");}
                    else if(i == 1){String  add = petition.getText().toString();
                    petition.setText(add.concat("e"));}
                    else if(i == 2 ){String  add = petition.getText().toString();
                    petition.setText(add.concat("t"));}
                    else if(i == 3){ String  add = petition.getText().toString();
                    petition.setText(add.concat("t"));}
                    else if(i == 4){ String  add = petition.getText().toString();
                    petition.setText(add.concat("i"));}
                    else if(i == 5){ String  add = petition.getText().toString();
                    petition.setText(add.concat(" "));}
                    else if(i == 6){ String  add = petition.getText().toString();
                    petition.setText(add.concat("A"));}
                    else if(i == 7){ String  add = petition.getText().toString();
                    petition.setText(add.concat("n"));}
                    else if(i == 8){ String  add = petition.getText().toString();
                    petition.setText(add.concat("s"));}
                    else if(i == 9){ String  add = petition.getText().toString();
                    petition.setText(add.concat("w"));}
                    else if(i == 10){ String  add = petition.getText().toString();
                    petition.setText(add.concat("e"));}
                    else if(i == 11){ String  add = petition.getText().toString();
                    petition.setText(add.concat("r"));}
                    else if(i == 12){ String  add = petition.getText().toString();
                    petition.setText(add.concat(" "));}
                    else if(i == 13){ String  add = petition.getText().toString();
                    petition.setText(add.concat("m"));}
                    else if(i == 14){ String  add = petition.getText().toString();
                    petition.setText(add.concat("y"));}
                    else if(i == 15){ String  add = petition.getText().toString();
                    petition.setText(add.concat(" "));}
                    else if(i == 16){ String  add = petition.getText().toString();
                    petition.setText(add.concat("q"));}
                    else if(i == 17){ String  add = petition.getText().toString();
                    petition.setText(add.concat("e"));}
                    else if(i == 18){ String  add = petition.getText().toString();
                    petition.setText(add.concat("s"));}
                    else if(i == 19){ String  add = petition.getText().toString();
                    petition.setText(add.concat("t"));}
                    else if(i == 20){ String  add = petition.getText().toString();
                    petition.setText(add.concat("i"));}
                    else if(i == 21){ String  add = petition.getText().toString();
                    petition.setText(add.concat("o"));}
                    else if(i == 22){ String  add = petition.getText().toString();
                    petition.setText(add.concat("n"));}
                    else if(i == 23) { String  add = petition.getText().toString();
                    petition.setText(add.concat(""));}
                    else{
                        petition.requestFocus();
                    }
                    if(hidentext.getText().toString().contains("."))
                    {
                        EditText hidentext = (EditText)findViewById(R.id.hidentext);
                        //storing answer
                        setPassAnswer(hidentext.getText().toString());
                        petition.requestFocus(i);
                        petition.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //On key event for Petition text,When you press comma focus moves to hiden text.

        EditText petition = (EditText)findViewById(R.id.petitiontext);
        petition.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText hiden = (EditText)findViewById(R.id.hidentext);
                int length = hiden.getText().toString().length();
                if(lenghth == 0)
                {
                hiden.requestFocus();
                }
            }
            
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                
            }
            
            @Override
            public void afterTextChanged(Editable s) {
                
            }
        });
        
        //Event to change the focus from petition to hiden
        final EditText sendfocustohiden = (EditText)findViewById(R.id.petitiontext);
        sendfocustohiden.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    while((keyCode == KeyEvent.KEYCODE_COMMA)){
                        EditText hidentext = (EditText)findViewById(R.id.hidentext);
                        sendfocustohiden.setText("p");
                        hidentext.requestFocus();
                        return true;
                    }
                return false;
            }

        });
        //Event to display the answer by clicking on submit button
        Button send = (Button)findViewById(R.id.sendAnswerButton);
        send.setOnClickListener(new OnClickListener() {
            EditText question = (EditText)findViewById(R.id.questionPetit);
            EditText hiden = (EditText)findViewById(R.id.hidentext);
            EditText petitquery = (EditText)findViewById(R.id.petitiontext);

            @Override
            public void onClick(View arg0) {

                boolean isQuestion = validate(question.getText().toString());
                boolean isAnswer = validate(hiden.getText().toString());
                //check whether the answer and petition is typed or not
                if(isQuestion && isAnswer)
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);

                    // set title
                    alertDialogBuilder.setTitle("HERE WE GO!!!!!!");

                    // set dialog message
                    alertDialogBuilder
                    .setMessage(getPassAnswer())
                    .setCancelable(false)
                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            Intent goToPlaypetti = new Intent(PlayPetitionActivity.this,CoreActivity.class);
                            startActivity(goToPlaypetti);
                            player.stop();
                        }
                    })
                    .setNegativeButton("PLAY AGAIN",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            question.setText("");
                            hiden.setText("");
                            petitquery.setText("");
                            dialog.dismiss();
                        }
                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
                else if(isQuestion && !isAnswer){
                    Context context = getApplicationContext();
                    String text = "there is no question to answer!!!!!";
                    int duration = Toast.LENGTH_SHORT;
                    player = MediaPlayer.create(PlayPetitionActivity.this, R.raw.second);
                    player.start();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    player = MediaPlayer.create(PlayPetitionActivity.this, R.raw.second);
                    player.start();
                    Context context = getApplicationContext();
                    String text = "ask me the question";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
    protected void onPause() {
        super.onPause();
        player.stop();
        finish();

    }
    
    //validation method
    private boolean validate(String string)
    {
        if(string.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }

    }

}











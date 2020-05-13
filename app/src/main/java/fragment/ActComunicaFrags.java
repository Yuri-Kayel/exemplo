package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.example.exemplo.R;

import static custom.ExtFunKt.hideSoftKeyBoard;

public class ActComunicaFrags extends AppCompatActivity implements ActivityContract {

    FragVermelho fragVermelho;
    FragVerde fragVerde;
    FragAzul fragAzul;

    FragmentManager fragManager = getSupportFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_comunica_frags);
        fragVermelho = (FragVermelho) fragManager.findFragmentById(R.id.frag_vermelho);
        fragVerde = (FragVerde) fragManager.findFragmentById(R.id.frag_verde);
        fragAzul = (FragAzul) fragManager.findFragmentById(R.id.frag_azul);
    }

    @Override
    public void setTextVermelho(String texto) {
        fragVermelho.setTextVermelho(texto);
        hideSoftKeyBoard(this);
    }

    @Override
    public void setTextVerde(String texto) {
        fragVerde.setTextVerde(texto);
        hideSoftKeyBoard(this);
    }

    @Override
    public void setTextAzul(String texto) {
        fragAzul.setTextAzul(texto);
        hideSoftKeyBoard(this);
    }
}

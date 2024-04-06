package com.example.unograham;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.unograham.databinding.ActivityCreateGameBinding;
import com.example.unograham.io.ApiService;
import com.example.unograham.io.response.ParticipantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class CreateGameActivity extends AppCompatActivity {

    private ActivityCreateGameBinding binding;
    private ApiService apiService;
    private SharedPreferences sharedPreferences;
    private List<String> participantsList;
    private ArrayAdapter<String> participantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiService = ApiService.create();
        sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE);

        participantsList = new ArrayList<>();
        participantsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantsList);
        binding.participantsListView.setAdapter(participantsAdapter);

        binding.inviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes abrir un desplegable para invitar amigos
                // Por ejemplo, puedes abrir una nueva actividad o un diálogo
                // y enviar la lista de amigos disponibles.
            }
        });

        // Obtener participantes de la partida desde el backend
        getParticipantsFromBackend();
    }

    private void getParticipantsFromBackend() {
        // Aquí realizamos una llamada al backend para obtener la lista de participantes
        // Esta es una llamada ficticia para demostración

        // Llamada a la API para obtener la lista de participantes
        apiService.getParticipants().enqueue(new Callback<List<ParticipantResponse>>() {
            @Override
            public void onResponse(Call<List<ParticipantResponse>> call, Response<List<ParticipantResponse>> response) {
                if (response.isSuccessful()) {
                    List<ParticipantResponse> participantResponses = response.body();
                    if (participantResponses != null) {
                        for (ParticipantResponse participant : participantResponses) {
                            participantsList.add(participant.getName());
                        }
                        participantsAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(CreateGameActivity.this, "No se encontraron participantes", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CreateGameActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ParticipantResponse>> call, Throwable t) {
                Toast.makeText(CreateGameActivity.this, "Error en la solicitud: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


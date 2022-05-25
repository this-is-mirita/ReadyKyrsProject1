package com.example.medicalhelp.ui.sunstrike;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.medicalhelp.R;
import com.example.medicalhelp.databinding.FragmentSunstrikeBinding;
import com.example.medicalhelp.utils.AppDbHandler;
import com.example.medicalhelp.dbs.ApplicationDatabase;
import com.example.medicalhelp.dbs.Entry;
import com.example.medicalhelp.dbs.EntryDao;

public class SunstrikeFragment extends Fragment {
    FragmentSunstrikeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSunstrikeBinding.inflate(
                inflater,
                container,
                false
        );
        TextView sunstrikeTitle = binding.sunstrikeTitle;
        TextView sunstrikeContent = binding.sunstrikeContent;
        _initiateComponent(sunstrikeTitle, sunstrikeContent);
        return binding.getRoot();
    }

    private void _initiateComponent(TextView sunstrikeTitle, TextView sunstrikeContent) {
        EntryDao db = AppDbHandler.getApplicationDatabase(getContext(),
                ApplicationDatabase.class,
                "default", true);
        Entry _thisEntry = db.getEntryById(R.id.nav_sunstrike);
        requireActivity().runOnUiThread(() -> {
            sunstrikeTitle.setText(_thisEntry.title);
            sunstrikeContent.setText(_thisEntry.content);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
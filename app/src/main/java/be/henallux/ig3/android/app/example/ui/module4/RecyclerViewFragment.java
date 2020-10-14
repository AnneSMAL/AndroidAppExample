package be.henallux.ig3.android.app.example.ui.module4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.room.Room;
import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.models.User;
import be.henallux.ig3.android.app.example.repositories.AppDatabase;
import be.henallux.ig3.android.app.example.repositories.UserRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {
    EditText firstNameEditText,lastNameEditText;
    RecyclerView usersRecyclerView;
    RoomExampleViewModel viewModel;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RoomExampleViewModel.class);

        View root = inflater.inflate(R.layout.mod4_fragment_recycler_view, container, false);

        usersRecyclerView = root.findViewById(R.id.list_of_users_recycler_view);

        final Button addUserButton = root.findViewById(R.id.add_user_button);
        firstNameEditText = root.findViewById(R.id.new_user_first_name_edit_text);
        lastNameEditText = root.findViewById(R.id.new_user_last_name_edit_text);
        addUserButton.setOnClickListener(this::addUser);

        /**
        * Observe the list of your ViewModel and update the list as necessary
        */
        UserAdapter adapter = new UserAdapter();
        viewModel.getObservableUsers().observe(getViewLifecycleOwner(), adapter::setUsers); //this.getA
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        usersRecyclerView.setAdapter(adapter);

        viewModel.getUsers();


        return root;
    }

// ----------------- ADAPTER FOR RECYCLERVIEW -------------------------
    /**
     * Create a private ViewHolder in the Activity, that describes a single element
     */
    private static class UserViewHolder extends RecyclerView.ViewHolder {

        // Declare all the fields of a single item here.
        public TextView firstName;
        public TextView lastName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name_text);
            lastName = itemView.findViewById(R.id.last_name_text);
        }
    }
    /**
     * Create an Adapter in the Activity, that will handle changes and layouts for each item
     */
    private static class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

        // Add the Java list you want to show, as a private variable
        private List<User> myUsers;

        //Implement the method OnCreateViewHolder, in the Adapter
        @NonNull
        @Override
        public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mod4_user_item_layout, parent, false);
            UserViewHolder vh = new UserViewHolder(v);
            return vh;
        }

        //Implement the method OnBindViewHolder, in the Adapter.
        //Bind all the fields of the ViewHolder in it
        @Override
        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            User u = myUsers.get(position);
            holder.firstName.setText(u.firstName);
            holder.lastName.setText(u.lastName);
        }

        //Implement the method GetItemCount, in the Adapter
        @Override
        public int getItemCount() {
            return myUsers == null ? 0 : myUsers.size();
        }

        //Add a setter for the private list in the Adapter. Call notifyDataSetChanged at the end of the setter
        public void setUsers(List<User> myUsers) {
            this.myUsers = myUsers;
            notifyDataSetChanged();
        }
    }

// ----------------- ADD USER & AsyncTask  -------------------------

    private void addUser(View view) {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        User newUser = new User(firstName,lastName);

        /**
         * You can't use the main thread to use the DB (Android is very touchy when handling UI).
         * You need Asynchronous work
         */
        new AddUserTask().execute(newUser);

    }

    /**
     * You can't use the main thread to use the DB (Android is very touchy when handling UI).
     * You need Asynchronous work (module 5 but here is an example)
     *
     * You need an inner class which extends AsyncTask<Params, Progress, Result> where :
     */
    private class AddUserTask extends AsyncTask<User, Void, String> {
        /**
         * doInBackground takes a parameter of type Params and return a type Result.
         * Executed on a second thread
         */
        protected String doInBackground(User... users) {
            viewModel.addUsers(users);
            viewModel.getUsers();

            Log.i("AddUser","add");
            return users[0].firstName;
        }

        /**
         * onPostExecute takes a parameter of type Result (which is what doInBackground return).
         * It is automatically call when doInBackground finish an is executed on main thread (UI)
         */
        protected void onPostExecute(String result) {
            Toast.makeText(getActivity().getApplicationContext(), "User "+result+" added", Toast.LENGTH_SHORT).show();
        }
    }

}
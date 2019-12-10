package com.example.welprating;
import android.util.Log;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseHelper {
    public FirebaseDatabase mDatabase;
    public DatabaseReference mReference;

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference();
    }
    
    public void addNewTA(String ta_name) {
        mReference.child(ta_name).setValue(new TA(ta_name));
    }

    public void updateTA(String name,final double new_Rating, final String comment) {
        mReference.child(name).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {

                TA p = mutableData.getValue(TA.class);
                System.out.println(p);
                if (p == null) {
                    return Transaction.success(mutableData);
                }
                System.out.println(new_Rating);
                p.updateCount();
                p.updateRating(new_Rating);
                p.averageIt();
                p.comments.add(comment);
                mutableData.setValue(p);
                return Transaction.success(mutableData);
            }
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
            }
        });
    }
    double value = 0;
    boolean done = false;
    public double getAverage(String name) {
        mReference.child(name).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {

                TA p = mutableData.getValue(TA.class);
                System.out.println(p);
                if (p == null) {
                    return Transaction.success(mutableData);
                }
                value = p.average;
                done = true;
                return Transaction.success(mutableData);
            }
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
            }
        });
        while (!done) {}
        return value;
    }
}

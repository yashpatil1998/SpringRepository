package yp.db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class PatientService {

	public static final String COL_NAME = "users";

	public String savePatientDetails(Patient patient) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(patient.getName())
				.set(patient);

		return collectionsApiFuture.get().getUpdateTime().toString();

	}

	public Patient getPatientDetails(String name) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
//		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
//		ApiFuture<DocumentSnapshot> future = documentReference.get();
//		DocumentSnapshot document = future.get();

		DocumentSnapshot document = dbFirestore.collection(COL_NAME).document(name).get().get();

		Patient patient = null;

		if (document.exists()) {
			patient = document.toObject(Patient.class);
			return patient;
		} else {
			return null;
		}
	}

	public static Iterable<DocumentReference> getAllDetailsIterable() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		return dbFirestore.collection(COL_NAME).listDocuments();

	}
	
	public List<Patient> getAllDetails() throws InterruptedException, ExecutionException {
		List<Patient> pList = new ArrayList<Patient>();
		Iterable<DocumentReference> itr = getAllDetailsIterable();
		
		for (DocumentReference d : itr)
			pList.add(d.get().get().toObject(Patient.class));
		
		return pList;
	}

	public String updatePatientDetails(Patient person) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(person.getName())
				.set(person);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deletePatient(String name) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
		return "Document with Patient ID " + name + " has been deleted";
	}

}

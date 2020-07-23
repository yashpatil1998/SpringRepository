package yp.db;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@RequestMapping("/")
    public String home(){
        return "Testing Firebase ";
    }

	@GetMapping("/getPatientDetails/{name}")
	public Patient getPatient(@PathVariable("name") String name) throws InterruptedException, ExecutionException {
		return patientService.getPatientDetails(name);
	}
	
	@GetMapping("/getPatientDetails")
	public List<Patient> getAllDetails() throws InterruptedException, ExecutionException {
		return patientService.getAllDetails();
	}

	@PostMapping("/createPatient")
	public String createPatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
		return patientService.savePatientDetails(patient);
	}

	@PutMapping("/updatePatient")
	public String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
		return patientService.updatePatientDetails(patient);
	}

	@DeleteMapping("/deletePatient")
	public String deletePatient(@RequestParam String name) {
		return patientService.deletePatient(name);
	}

}

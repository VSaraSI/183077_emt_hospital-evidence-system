import axios from '../custom-axios/axios';

const HospitalService = {
    fetchPatients: () => {
       return axios.get("/patient")
    },
    fetchDoctors: () => {
    return axios.get("/patient/doctors")
    },
    fetchNurses: () => {
        return axios.get("/patient/nurses")
    },
    addPatient: (name, address, telephone ,ward, doctorId, nurseId) => {
        return axios.post("/patient/add", {
            "name" : name,
            "address" : address,
            "telephone" : telephone,
            "ward" : ward,
            doctorId : doctorId,
            nurseId : nurseId
        });
    },
    deletePatient: (id) => {
        return axios.delete(`/patient/delete/${id}`);
    },
    changeDoctorOrNurse: (id, name, address, telephone ,ward, doctorId,nurseId) => {
        return axios.put(`/patient/changeDoctorOrNurse/${id}`, {
            "name" : name,
            "address" : address,
            "telephone" : telephone,
            "ward" : ward,
            doctorId : doctorId,
            nurseId : nurseId
        })
    },
    getPatient: (id) => {
        return axios.get(`/patient/${id}`);
}
}

export default HospitalService;

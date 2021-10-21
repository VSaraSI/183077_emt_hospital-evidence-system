import axios from '../custom-axios/axios';

const CartonService = {
    fetchCartons: () => {
       return axios.get("/carton")
    },
    fetchPatients: () => {
        return axios.get("/carton/patients")
    },
    addCarton: (problem, ward, patientId) => {
        return axios.post("/carton/add", {
            "problem" : problem,
            "ward" : ward,
            "patientId" : patientId
        });
    },
    deleteCarton: (id) => {
        return axios.delete(`/carton/delete/${id}`);
    },
    editCarton: (id,problem,ward, patientId) => {
        return axios.put(`/carton/edit/${id}`, {
            "problem" : problem,
            "ward" : ward,
            "patientId" : patientId
        });
    },
    getCarton: (id) => {
        return axios.get(`/carton/${id}`);
    }
}

export default CartonService;

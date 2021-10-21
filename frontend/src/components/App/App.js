import './App.css';
import React, {Component} from "react";
import Patients from '../Patients/patient';
import HospitalService from "../../repository/hospitalRepository";
import {BrowserRouter as Router, Route, Redirect} from 'react-router-dom'
import PatientAdd from '../Patients/PatientAdd';
import DoctorChangeOrNurse from "../Patients/DoctorChangeOrNurse";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            patients: [],
            doctors: [],
            nurses: [],
            selectedPatient: {}
        }
    }

    render() {
        return (
            <Router>
                <main>
                    <div className="container">
                        <Route path={"/patient/add"} exact render={() =>
                            <PatientAdd doctors={this.state.doctors}
                                        nurses={this.state.nurses}
                                onAddPatient={this.addPatient}/>}/>
                        <Route path={"/patient/changeDoctorOrNurse/:id"} exact render={() =>
                            <DoctorChangeOrNurse onChangeDoctorOrNurse={this.changeDoctorOrNurse}
                                                 doctors={this.state.doctors}
                                                 nurses={this.state.nurses}
                                                 patient={this.state.selectedPatient}/>}/>
                        <Route path={"/patient"} exact render={() =>
                            <Patients patients={this.state.patients}
                                      doctors={this.state.doctors}
                                      nurses={this.state.nurses}
                                      onDelete={this.deletePatient}
                                      onChangeDoctorOrNurse={this.getPatient}/>}/>
                        <Redirect to={"/patient"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadPatients();
        this.loadDoctors();
        this.loadNurses();
    }


    loadPatients = () => {
        HospitalService.fetchPatients()
            .then((data) => {
                this.setState({
                    patients: data.data
                })
            });
    }

    addPatient = (name, address, telephone, ward,doctorId,nurseId) => {
        HospitalService.addPatient(name, address, telephone, ward, doctorId,nurseId)
            .then(() => {
                this.loadPatients();
            });
    }

    deletePatient = (id) => {
        HospitalService.deletePatient(id)
            .then(() => {
                this.loadPatients();
            });
    }

    changeDoctorOrNurse = (id,name, address, telephone,ward, doctorId,nurseId) => {
        HospitalService.changeDoctorOrNurse(id,name, address,telephone,ward, doctorId, nurseId)
            .then(() => {
                this.loadPatients();
            })
    }

    loadDoctors = () => {
        HospitalService.fetchDoctors()
            .then((data) => {
                this.setState({
                    doctors: data.data
                })
            });
    }

    loadNurses = () => {
        HospitalService.fetchNurses()
            .then((data) => {
                this.setState({
                    nurses: data.data
                })
            });
    }

    getPatient = (id) => {
       HospitalService.getPatient(id)
            .then((data) => {
                this.setState({
                    selectedPatient: data.data
                })
            })
    }

}


export default App;

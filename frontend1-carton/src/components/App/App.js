import './App.css';
import React, {Component} from "react";
import CartonService from "../../repository/cartonRepository";
import {BrowserRouter as Router, Route, Redirect} from 'react-router-dom'
import Carton from "../Cartons/carton";
import CartonAdd from "../Cartons/CartonAdd";
import CartonEdit from "../Cartons/cartonEdit";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      cartons: [],
        patients: [],
      selectedCarton: {}
    }
  }

  render() {
    return (
        <Router>
          <main>
            <div className="container">
                <Route path={"/carton/add"} exact render={() =>
                    <CartonAdd  patients={this.state.patients}
                                onAddCarton={this.addCarton}/>}/>
                <Route path={"/carton/edit/:id"} exact render={() =>
                    <CartonEdit onEditCarton={this.editCarton}
                                patients={this.state.patients}
                                 carton={this.state.selectedCarton}/>}/>
                <Route path={"/carton"} exact render={() =>
                  <Carton cartons={this.state.cartons}
                          patients={this.state.patients}
                            onDelete={this.deleteCarton}
                                onEdit={this.getCarton}/>}/>
              <Redirect to={"/carton"}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadCartons();
    this.loadPatients();
  }


  loadCartons = () => {
    CartonService.fetchCartons()
        .then((data) => {
          this.setState({
            cartons: data.data
          })
        });
  }

  addCarton = (problem,ward,patientId) => {
    CartonService.addCarton(problem,ward,patientId)
        .then(() => {
          this.loadCartons();
        });
  }

  deleteCarton= (id) => {
    CartonService.deleteCarton(id)
        .then(() => {
          this.loadCartons();
        });
  }

    getCarton = (id) => {
        CartonService.getCarton(id)
            .then((data) => {
                this.setState({
                    selectedCarton: data.data
                })
            })
    }

    editCarton = (id, problem,ward,patientId) => {
        CartonService.editCarton(id, problem, ward, patientId)
            .then(() => {
                this.loadCartons();
            });
    }

    loadPatients = () => {
        CartonService.fetchPatients()
            .then((data) => {
                this.setState({
                    patients: data.data
                })
            });
    }

}


export default App;

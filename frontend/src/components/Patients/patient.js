import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import PatientTerm from '../Patients/PatientTerm';
import {Link} from 'react-router-dom';
import ReactPaginate from 'react-paginate';

class Patient extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 10
        }
    }
    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.patients.length / this.state.size);
        const patients = this.getPatientsPage(offset, nextPageOffset);


        return (
        <div className={"container mm-4 mt-5"}>
            <h1>Evidence of patients</h1>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Address</th>
                            <th scope={"col"}>Telephone</th>
                            <th scope={"col"}>Ward</th>
                            <th scope={"col"}>Doctor</th>
                            <th scope={"col"}>Nurse</th>
                        </tr>
                        </thead>
                        <tbody>
                        {patients}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/patient/add"}>Add new patient</Link>
                        </div>
                    </div>
                </div>
            </div>
            <ReactPaginate previousLabel={"back"}
                           nextLabel={"next"}
                           breakLabel={<a href="/#">...</a>}
                           breakClassName={"break-me"}
                           pageClassName={"ml-1"}
                           pageCount={pageCount}
                           marginPagesDisplayed={2}
                           pageRangeDisplayed={5}
                           onPageChange={this.handlePageClick}
                           containerClassName={"pagination m-4 justify-content-center"}
                           activeClassName={"active"}/>
        </div>
    );}
        handlePageClick = (data) => {
            let selected = data.selected;
            this.setState({
                page: selected
            })
        }

        getPatientsPage = (offset, nextPageOffset) => {
        let doctors=this.props.doctors;
        let nurses=this.props.nurses;
            return this.props.patients.map((term, index) => {
                return (
                    <PatientTerm term={term} doctors={doctors} nurses={nurses} onDelete={this.props.onDelete} onChangeDoctorOrNurse={this.props.onChangeDoctorOrNurse}/>
                );
            }).filter((patient, index) => {
                return index >= offset && index < nextPageOffset;
            })
        }

}

export default Patient;

import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import CartonTerm from './cartonTerm';
import {Link} from 'react-router-dom';
import ReactPaginate from 'react-paginate';

class Carton extends React.Component {

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
        const pageCount = Math.ceil(this.props.cartons.length / this.state.size);
        const cartons = this.getCartonsPage(offset, nextPageOffset);


        return (
        <div className={"container mm-4 mt-5"}>
            <h1>Medical carton evidence</h1>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Patient</th>
                            <th scope={"col"}>Problem</th>
                            <th scope={"col"}>Ward</th>
                            <th scope={"col"}>Date of creation</th>
                        </tr>
                        </thead>
                        <tbody>
                        {cartons}
                        </tbody>
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/carton/add"}>Add new carton</Link>
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

    getCartonsPage = (offset, nextPageOffset) => {
        let patients=this.props.patients;
        return this.props.cartons.map((term, index) => {
            return (
                <CartonTerm term={term} patients={patients} onDelete={this.props.onDelete} onEdit={this.props.onEdit}/>
            );
        }).filter((carton, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }


}

export default Carton;

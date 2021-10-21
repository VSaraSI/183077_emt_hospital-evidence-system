import React from 'react';
import {Link} from 'react-router-dom';

const cartonTerm = (props) => {
    return (
        <tr>

            {props.patients.filter(patient => patient.id.id === props.term.patientId.id).map(searchedPatient => (
                <td>{searchedPatient.name+ ' - ' + searchedPatient.telephone}</td>
            ))}

            <td>{props.term.problem}</td>
            <td>{props.term.ward.wardName}</td>
            <td>{props.term.creationDate}</td>

            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-outline-warning"}
                   onClick={() => props.onDelete(props.term.id.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id.id)}
                      to={`/carton/edit/${props.term.id.id}`}>
                    Edit
                </Link>
            </td>

        </tr>
    )
}

export default cartonTerm;

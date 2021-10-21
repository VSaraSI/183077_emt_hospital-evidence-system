import React from 'react';
import {Link} from "react-router-dom";

const patientTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.address}</td>
            <td>{props.term.telephone}</td>
            <td>{props.term.ward.wardName}</td>

            {props.doctors.filter(doctor => doctor.id.id === props.term.doctorId.id).map(searchedDoctor => (
            <td>{searchedDoctor.name+ ' - ' + searchedDoctor.qualification}</td>
               ))}

            {props.nurses.filter(nurse => nurse.id.id === props.term.nurseId.id).map(searchedNurse => (
                <td>{searchedNurse.name+ ' - ' + searchedNurse.ward.wardName}</td>
            ))}

            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-outline-warning"}
                   onClick={() => props.onDelete(props.term.id.id)}>
                    Delete
                </a>
                <Link className={"btn btn-success ml-2"}
                      onClick={() => props.onChangeDoctorOrNurse(props.term.id.id)}
                      to={`/patient/changeDoctorOrNurse/${props.term.id.id}`}>
                    Change Doctor/Nurse
                </Link>
            </td>
        </tr>
    )
}

export default patientTerm;

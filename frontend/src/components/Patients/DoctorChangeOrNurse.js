import React from 'react';
import {useHistory} from 'react-router-dom';

const DoctorChangeOrNurse = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name : "",
        address : "",
        telephone : "",
        ward : "",
        doctorId : 0,
        nurseId : 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();

        const name = formData.name !== "" ? formData.name : props.patient.name;
        const address = formData.address !== "" ? formData.address : props.patient.address;
        const telephone = formData.telephone !== "" ? formData.telephone : props.patient.telephone;
        const ward = formData.ward !== "" ? formData.ward : props.patient.ward;
        const doctorId = formData.doctorId  !== 0 ? formData.doctorId : props.patient.doctorId;
        const nurseId = formData.nurseId !== 0 ? formData.nurseId : props.patient.nurseId;

        props.onChangeDoctorOrNurse(props.patient.id.id,name,address,telephone,ward,doctorId,nurseId);
        history.push("/patient");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Patient name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.patient.name}
                               onChange={handleChange}
                               disabled
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="address">Address</label>
                        <input type="text"
                               className="form-control"
                               id="address"
                               name="address"
                               placeholder={props.patient.address}
                               disabled
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="telephone">Telephone</label>
                        <input type="number"
                               className="form-control"
                               id="telephone"
                               name="telephone"
                               placeholder={props.patient.telephone}
                               disabled
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="ward">Ward</label>
                        <input type="text"
                               className="form-control"
                               id="ward"
                               name="ward"
                               disabled
                               onChange={handleChange}
                        />
                    </div>
                <div className="form-group">
                        <label>Doctor</label>
                        <select name="doctorId" className="form-control" onChange={handleChange}>
                            {props.doctors.map((term) => {
                                if(props.patient.doctorId !== undefined &&
                                    props.patient.doctorId.id === term.id.id)
                                    return <option selected={props.patient.doctorId.id} value={term.id.id}>{term.name} - {term.qualification}</option>
                                else return <option value={term.id.id}>{term.name} - {term.qualification}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Nurse</label>
                        <select name="nurseId" className="form-control" onChange={handleChange}>
                            {props.nurses.map((term) => {
                                if(props.patient.nurseId !== undefined &&
                                    props.patient.nurseId.id === term.id.id)
                                    return <option selected={props.patient.nurseId.id} value={term.id.id}>{term.name}</option>
                                else return <option value={term.id.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default DoctorChangeOrNurse;

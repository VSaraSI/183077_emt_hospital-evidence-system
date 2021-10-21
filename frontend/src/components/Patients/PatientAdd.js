import React from 'react';
import {useHistory} from 'react-router-dom';

const PatientAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        address: "",
        telephone: "",
        ward: "",
        doctorId: 0,
        nurseId: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const address = formData.address;
        const telephone = formData.telephone;
        const ward = formData.ward;
        const doctorId = formData.doctorId;
        const nurseId = formData.nurseId;

        props.onAddPatient(name, address,telephone,ward,doctorId,nurseId);
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
                               required
                               placeholder="Enter patient name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="address">Address</label>
                        <input type="text"
                               className="form-control"
                               id="address"
                               name="address"
                               placeholder="Address"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="telephone">Telephone</label>
                        <input type="number"
                               className="form-control"
                               id="telephone"
                               name="telephone"
                               placeholder="Telephone"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="ward">Ward</label>
                        <input type="text"
                               className="form-control"
                               id="ward"
                               name="ward"
                               placeholder="Ward"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Doctor</label>
                        <select name="doctorId" className="form-control" onChange={handleChange} required>
                            <option hidden></option>
                            {props.doctors.map((term) =>
                                <option value={term.id.id}>{term.name} - {term.qualification}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Nurse</label>
                        <select name="nurseId" className="form-control" onChange={handleChange} required>
                            <option hidden></option>
                            {props.nurses.map((term) =>
                                <option value={term.id.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default PatientAdd;

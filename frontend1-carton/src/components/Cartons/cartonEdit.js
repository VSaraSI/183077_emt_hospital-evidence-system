import React from 'react';
import {useHistory} from 'react-router-dom';

const CartonEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        problem : "",
        ward : "",
        patientId: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();

        const problem = formData.problem !== "" ? formData.problem : props.carton.problem;
        const ward = formData.ward !== "" ? formData.ward : props.carton.ward;
        const patientId = formData.patientId  !== "" ? formData.patientId : props.carton.patientId;

        props.onEditCarton(props.carton.id.id, problem, ward, patientId);
        history.push("/carton");
    }

    return(
    <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="problem">Problem</label>
                        <input type="text"
                               className="form-control"
                               id="problem"
                               name="problem"
                               placeholder={props.carton.problem}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="wardName">Ward</label>
                        <input type="text"
                               className="form-control"
                               id="ward"
                               name="ward"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Patient</label>
                        <select name="patientId" className="form-control" onChange={handleChange} disabled>
                            {props.patients.map((term) => {
                                if(props.carton.patientId !== undefined &&
                                    props.carton.patientId.id === term.id.id)
                                    return <option selected={props.carton.patientId.id} value={term.id.id}>{term.name}</option>
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

export default CartonEdit;

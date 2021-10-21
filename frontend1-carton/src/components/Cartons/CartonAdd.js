import React from 'react';
import {useHistory} from 'react-router-dom';

const CartonAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        problem : "",
        ward : "",
        patientId : ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const problem = formData.problem;
        const ward = formData.ward;
        const patientId= formData.patientId;

        props.onAddCarton(problem,ward,patientId);
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
                               required
                               placeholder="Enter problem"
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
                        <label>Patient</label>
                        <select name="patientId" className="form-control" onChange={handleChange}>
                            <option hidden> </option>
                            {props.patients.map((term) =>
                                <option value={term.id.id}>{term.name} - {term.telephone}</option>
                            )}
                        </select>
                        <p>In system one patinet has one medical carton. If the carton
                        is not created then the patient already had open medical carton.</p>
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default CartonAdd;

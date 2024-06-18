//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0);
  const [university, setUniversity] = useState([]);
  const idRef = useRef();
  const nameRef = useRef();
  const locationRef = useRef();
  const totalStudentsRef = useRef();
  const [departments, setDepartments] = useState([]);
  const [departmentName, setDepartmentName] = useState('');
  const [numberOfStudents, setNumberOfStudents] = useState('');
  const [universityId, setUniversityId] = useState('');
  const departmentNameRef = useRef();
  const numberOfStudentsRef = useRef();
  const universityIdRef = useRef();


  useEffect(() => {
    fetch("http://localhost:8080/api/universities")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setUniversity(json);
      });

    fetch("http://localhost:8080/api/departments")
      .then (response => response.json())
      .then(json => {
        setDepartments(json);
      });
  }, []);

  function kustuta(id) {
    fetch("http://localhost:8080/api/universities/" + id, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setUniversity(json);
      })
  }

  function lisa() {
    if (nameRef.current.value.trim() === "") {
         return;
       }
       fetch("http://localhost:8080/api/universities/" 
            + idRef.current.value + "/"     
            + nameRef.current.value + "/"
            + locationRef.current.value + "/"
            + totalStudentsRef.current.value, 
       {
         "method": "POST"
       })
         .then(response => response.json()) 
         .then(json => {
           setKogus(json.length);
           setUniversity(json);
         })
  }

  function addDepartment() {
    const departmentData = {
      name: departmentNameRef.current.value, 
      numberOfStudents: parseInt(numberOfStudentsRef.current.value, 10),
      university: {id: parseInt(universityIdRef.current.value, 10)},
    };

    fetch("http://localhost:8080/api/departments", {
      method: "POST", 
      headers: {
        "Content-Type": "application/json", 
      }, 
      body: JSON.stringify(departmentData),
    })
      .then (response => response.json()) 
      .then(json => {
        setDepartments(json);
        setDepartmentName('');
        setNumberOfStudents('');
        setUniversityId('');
      });
  }

  function deleteDepartment(id) {
    fetch(`http://localhost:8080/api/departments/${id}`, {
      method: "DELETE",
    })
      .then(response => response.json())
      .then(json => {
        setDepartments(json);
      });
  }

  return (
    <div className="App">
      Kokku on {kogus} ülikooli.
      <br /><br />
      
      <label>Ülikooli ID</label> <br/>
      <input ref={idRef} type="text" /> <br />
      <label>Ülikooli nimi</label> <br/>
      <input ref={nameRef} type="text" /> <br />
      <label>Ülikooli asukoht</label> <br/>
      <input ref={locationRef} type="text" /> <br />
      <label>Ülikooli tudengite arv</label> <br/>
      <input ref={totalStudentsRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {university.map(u => <div>{u.id} | {u.name} | {u.location} | {u.totalStudents} <button onClick={() => kustuta(u.id)}>x</button> </div>)} 
    
      <br /><br />
      <hr></hr>
      Instituudid: 
      <br /><br />
      <label>Instituudi nimi</label> <br/>
      <input ref={departmentNameRef} type="text" /> <br />
      <label>Tudengite arv osakonnas</label> <br/>
      <input ref={numberOfStudentsRef} type="text" /> <br />
      <label>Ülikooli ID</label> <br/>
      <input ref={universityIdRef} type="text" /> <br />
      <button onClick={() => addDepartment()}>Sisesta</button> <br />

      {departments.map(d => <div>{d.id} | {d.name} | {d.numberOfStudents} | Ülikooli ID: {d.universityId} <button onClick={() => deleteDepartment(d.id)}>x</button> </div>)}

    </div>

  
  );
}

export default App;

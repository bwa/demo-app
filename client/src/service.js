import axios from 'axios';

export const Test = (caller) => {
    axios.get(
        '/api/demo/hello'
      ).then((response) => {
      console.log("Test response:",response);

      if(response.status === 204) {
        console.log("Data ikke funnet");
        caller.setState({data:"not found"});
        return;
      }
      caller.setState({data:response.data});
      console.log("Test state=",caller.state);
      
    })
    .catch(error => {
        console.log("Feil oppstod med kall til /api/demo/Hello : ",error)
      })
          
    .finally(function () {
        console.log("Test finally OK");
      });
};
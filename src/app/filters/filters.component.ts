import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { CustomerService } from '../customer.service';

declare var $:any;



@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {

  data:any;
  value:boolean;
  constructor(private _service : CustomerService) { }

  ngOnInit(): void {
  }
  
  changeDate()
  {
   $('#sinput').prop('type',$('#selectType').val());
   
  }

  getData(){
  var dateType=$('#selectType').val();
   var dateValue=$('#sinput').val();
    if (dateType == "number")
      dateType = "year";
    else if (dateType == "month" || dateType == "week")
      dateValue = dateValue.slice(-2,)
    if(dateType=="week")
      dateValue=(parseInt(dateValue)-1).toString()
      var semail=sessionStorage.getItem('semail');
      this._service.getFrequency(semail,dateType,dateValue).subscribe(
        data=>{
          if(data.length>0){
          this.value =true;
          this.data=data;
          }
          else{
            this.value = false;
          }
        }
      )
     }
  
  

}

import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
 

  constructor(private snackBar:MatSnackBar) { }

  public showSuccessMessage(message: string): void {
    this.snackBar.open(message,"close",{
      duration:2000,
      panelClass:["green-snackbar"],
      horizontalPosition:'end',
      verticalPosition:"top"
    });
  }
    public showErrorMessage(message:string):void {
      this.snackBar.open(message,"close",{
        duration:2000,
        panelClass:["res-snackbar"],
        horizontalPosition:'end',
        verticalPosition:'top'
      });
    }
    
}

package by.tms.module2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashBox {
 private int number;
 private boolean isReady;
 private int queueSize = 0;

 public CashBox(int number, boolean isReady) {
  this.number = number;
  this.isReady = isReady;
 }
}

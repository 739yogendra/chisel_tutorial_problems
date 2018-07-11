// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a loadable delays register with four 4-bit stages using Vec
// delays occurs if 'delays' is asserted
// Load  occurs if 'load'  is asserted
// Whole state should be replaced with 'ins' when loaded
//
class VecdelaysRegister extends Module {
  val io = IO(new Bundle {
    val ins   = Input(Vec(4, UInt(4.W)))
    val load  = Input(Bool())
    val delays = Input(Bool())
    val out   = Output(UInt(4.W))
  })
  // Implement below ----------
  
  val delays = Reg(Vec(4,UInt(4.W))
      
  when (io.load){
    delays(0) := io.ins(0)
    delays(1) := io.ins(1)
    delays(2) := io.ins(2)
    delays(3) := io.ins(3)
  }.elsewhen (io.delays){
    delays(0) := io.ins(0)
    delays(1) := delays(0)
    delays(2) := delays(1)
    delays(3) := delays(2)
  }

  io.out := delays(3)

  // Implement above ----------
}



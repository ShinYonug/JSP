
package com.saeyan.controller.action;


public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " +  command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action= new BoardFormAction();
		}else if ( command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if ( command.equals("board_view")) {
			action = new BoardViewAction();
		}else if ( command.equals("board_check_pass_form")) {
			action = new BoardCheckFormPassAcion();
		}else if ( command.equals("board_check_pass")) {
			action = new BoardCheckPassAcion();
			
	}
		return action;

}
}

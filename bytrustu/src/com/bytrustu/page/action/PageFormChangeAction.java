package com.bytrustu.page.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bytrustu.common.action.Action;
import com.bytrustu.common.action.ActionForward;

public class PageFormChangeAction implements Action {
  
  // contentPage 경로값 기본 path
  private String form = "SubRightSideForm.jsp";
  private String path;
  
  // command *.do 입력값 앞까지 잘라서 입력받은 name 값을 받아온다.
  public void setCommand(String command) {
    int index = command.indexOf(".");
    path = command.substring(0, index) + ".jsp";
  }
  
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    System.out.println("경로>>>>>>>>>>>"+path);
    
    // MainForm 일 경우 MainForm.jsp 경로로 지정
    if (path.equals("MainForm.jsp")) {
      forward.setNextPath(path);
    } else if (path.equals("SubRightSideForm.jsp")) {
      forward.setNextPath(path);
      System.out.println(">>>>>>>>>>>>>>>1111");
    }
    
    // *.page 확장자 패턴으로 시작되는 경우 content 값의 경로를 기본으로 path 값을 추가해서 지정
    else {
      forward.setNextPath(form);
    }
    return forward;
  }
}

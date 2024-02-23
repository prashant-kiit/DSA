// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>
using namespace std;

int precedence(char a) {
  if (a == '+')
    return 1;
  else if (a == '-')
    return 1;
  else if (a == '*')
    return 3;
  else if (a == '/')
    return 3;
  else 
    return -1;
}

string infixPostfix(string infix) {
  string sep = " ";
  string postfix="";
  vector <char> stack={'@'};
  int len=infix.length();
  for (int i=0; i<len; i++)
  for (int i=0; i<len; i++) {
      if (iswalnum(infix[i])) {
          postfix=postfix + infix[i];
      }
      else if ((infix.at(i) == '+') || (infix.at(i) == '-') || (infix.at(i) == '*') ||
      (infix.at(i) == '/')) {
        if (precedence(infix[i]) > precedence(stack.back())) {
          stack.push_back(infix[i]);
        }
        else {
          while(precedence(infix[i]) <= precedence(stack.back())) {
              postfix=postfix + stack[stack.size()-1];
              stack.pop_back();
          } 
          stack.push_back(infix[i]);
        }
      }
    }
  while (stack.size()!=1) {
    postfix=postfix + stack[stack.size()-1];
    stack.pop_back();
  }
  return postfix;
}

int main() {
    // Write C++ code here
    string infix="A+B+C*D/E+F";
    cout<<infixPostfix(infix)<<endl;
    return 0;
}
//
//  QuestionViewController.h
//  classroom
//
//  Created by Kester Guischard on 4/23/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CommentViewController.h"
#import "User.h"
#import "Question.h"
#import "Course.h"


@interface QuestionViewController : UIViewController{
    UILabel *test;
    UIButton *qButton;
    User *currUser;
    Course *selCourse;
    id response;
    
    NSMutableArray *questionList;
    Question *question;
    int numOfQuestions;
    UITextField *questionText;
    UILabel *qLabel;
    CommentViewController *commentViewCtrl;
}

@property (nonatomic, strong) UILabel *test;
@property (nonatomic, strong) UIButton *qButton;
@property (nonatomic, strong) User *currUser;
@property (nonatomic, strong) Course *selCourse;
@property id response;

@property (nonatomic, strong) NSMutableArray *questionList;
@property (nonatomic, strong) Question *question;
@property (nonatomic, strong) UITextField *questionText;
@property (nonatomic, strong) UILabel *qLabel;
@property int numOfQuestions;

@property (nonatomic, strong) CommentViewController *commentViewCtrl;

@end

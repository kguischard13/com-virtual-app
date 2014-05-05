//
//  NoteViewController.m
//  classroom
//
//  Created by Christopher Forehand on 4/10/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#define frameWidth self.view.frame.size.width
#define frameHeight self.view.frame.size.height

#import "NoteViewController.h"


@implementation NoteViewController

@synthesize btnEdit, btnExport, btnSave, btnViewSlides, imgNoteViewer;

- (id)init
{
    if(self == [super init])
    {
        self.view.backgroundColor = [UIColor colorWithRed:.22 green:.72 blue:.80 alpha:1.0];
        self.title = @"Virtual Classroom - Notes";
        
        UIScrollView *scrollView = [[UIScrollView alloc] initWithFrame:CGRectMake(0, 0, self.view.frame.size.height, self.view.frame.size. width)];
        scrollView.backgroundColor = [UIColor clearColor];
        scrollView.pagingEnabled = YES;
        
        
        
        btnEdit = [[UIButton alloc] initWithFrame:CGRectMake(20, 200, frameHeight*.15, frameWidth*.10)];
        [btnEdit setTitle:@"Edit Note" forState:UIControlStateNormal];
        [[btnEdit layer] setBorderWidth:2.0f];
        [[btnEdit layer] setCornerRadius:4.0];
        [[btnEdit layer] setBorderColor:[UIColor whiteColor].CGColor];
        //btnEdit.tag = ButtonTypeComp;
        //[btnEdit addTarget:self action:@selector(buttonTouchUpInside:) forControlEvents:UIControlEventTouchDown];
        [scrollView addSubview:btnEdit];
        
        btnSave = [[UIButton alloc] initWithFrame:CGRectMake(20, 300, frameHeight*.15, frameWidth*.10)];
        [btnSave setTitle:@"Save Note" forState:UIControlStateNormal];
        [[btnSave layer] setBorderWidth:2.0f];
        [[btnSave layer] setCornerRadius:4.0];
        [[btnSave layer] setBorderColor:[UIColor whiteColor].CGColor];
        //btnEdit.tag = ButtonTypeComp;
        //[btnEdit addTarget:self action:@selector(buttonTouchUpInside:) forControlEvents:UIControlEventTouchDown];
        [scrollView addSubview:btnSave];
        
        btnExport = [[UIButton alloc] initWithFrame:CGRectMake(20, 400, frameHeight*.15, frameWidth*.10)];
        [btnExport setTitle:@"Export Note" forState:UIControlStateNormal];
        [[btnExport layer] setBorderWidth:2.0f];
        [[btnExport layer] setCornerRadius:4.0];
        [[btnExport layer] setBorderColor:[UIColor whiteColor].CGColor];
        //btnEdit.tag = ButtonTypeComp;
        //[btnEdit addTarget:self action:@selector(buttonTouchUpInside:) forControlEvents:UIControlEventTouchDown];
        [scrollView addSubview:btnExport];
        
        btnViewSlides = [[UIButton alloc] initWithFrame:CGRectMake(20, 500, frameHeight*.15, frameWidth*.10)];
        [btnViewSlides setTitle:@"View Slides" forState:UIControlStateNormal];
        [[btnViewSlides layer] setBorderWidth:2.0f];
        [[btnViewSlides layer] setCornerRadius:4.0];
        [[btnViewSlides layer] setBorderColor:[UIColor whiteColor].CGColor];
        //btnEdit.tag = ButtonTypeComp;
        //[btnEdit addTarget:self action:@selector(buttonTouchUpInside:) forControlEvents:UIControlEventTouchDown];
        [scrollView addSubview:btnViewSlides];
        
        imgNoteViewer = [[UIImageView alloc] initWithFrame:CGRectMake(230, 100, frameHeight*.75, frameWidth*.80)];
        [[imgNoteViewer layer] setBorderWidth:2.0f];
        [[imgNoteViewer layer] setCornerRadius:4.0];
        [[imgNoteViewer layer] setBorderColor:[UIColor whiteColor].CGColor];
        [scrollView addSubview:imgNoteViewer];
        
        
        scrollView.contentSize = CGSizeMake(scrollView.frame.size.height,scrollView.frame.size.width);
        [self.view addSubview:scrollView];
    }
    
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end

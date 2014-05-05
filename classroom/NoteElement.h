//
//  NoteElement.h
//  Test
//
//  Created by Kester Guischard on 4/4/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NoteElement : NSObject{
    int Id;
    int ParentId;
}


@property int Id;
@property int ParentId;
@property (nonatomic, retain) NSString *ElementType;
@property (nonatomic, retain) NSString *Message;
@property (nonatomic, retain) NSDate *DateCreated;
@property (nonatomic, retain) NSDate *DateModified;


@end

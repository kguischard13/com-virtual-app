//
//  Enums.h
//  classroom
//
//  Created by Christopher Forehand on 4/10/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#ifndef VirtualClassroom_Enums_h
#define VirtualClassroom_Enums_h

typedef enum ButtonType : NSInteger ButtonType;
enum ButtonType : NSInteger {
    ButtonTypeComp,
    ButtonTypeReco,
    ButtonTypeViewComps,
    ButtonTypeViewRecos,
    ButtonTypeViewMap
};

typedef enum TextField : NSInteger TextField;
enum TextField : NSInteger {
    TextFieldLocation,
    TextFieldComplaint,
    TextFieldRequest
};

typedef enum ViewMode : NSInteger ViewMode;
enum ViewMode : NSInteger {
    ViewModeWrite,
    ViewModeReadOnly,
    ViewModeRequestWriteComplaint,
    ViewModeRequestWriteReco
};



#endif

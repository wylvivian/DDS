

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from cft.idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

#ifndef cft_697328332_h
#define cft_697328332_h

#ifndef NDDS_STANDALONE_TYPE
#ifndef ndds_cpp_h
#include "ndds/ndds_cpp.h"
#endif
#else
#include "ndds_standalone_type.h"
#endif

extern "C" {

    extern const char *cftTYPENAME;

}

struct cftSeq;
#ifndef NDDS_STANDALONE_TYPE
class cftTypeSupport;
class cftDataWriter;
class cftDataReader;
#endif

class cft 
{
  public:
    typedef struct cftSeq Seq;
    #ifndef NDDS_STANDALONE_TYPE
    typedef cftTypeSupport TypeSupport;
    typedef cftDataWriter DataWriter;
    typedef cftDataReader DataReader;
    #endif

    DDS_Long   x ;
    DDS_Long   count ;

};
#if (defined(RTI_WIN32) || defined (RTI_WINCE)) && defined(NDDS_USER_DLL_EXPORT)
/* If the code is building on Windows, start exporting symbols.
*/
#undef NDDSUSERDllExport
#define NDDSUSERDllExport __declspec(dllexport)
#endif

NDDSUSERDllExport DDS_TypeCode* cft_get_typecode(void); /* Type code */

DDS_SEQUENCE(cftSeq, cft);                                        

NDDSUSERDllExport
RTIBool cft_initialize(
    cft* self);

NDDSUSERDllExport
RTIBool cft_initialize_ex(
    cft* self,RTIBool allocatePointers,RTIBool allocateMemory);

NDDSUSERDllExport
RTIBool cft_initialize_w_params(
    cft* self,
    const struct DDS_TypeAllocationParams_t * allocParams);        

NDDSUSERDllExport
void cft_finalize(
    cft* self);

NDDSUSERDllExport
void cft_finalize_ex(
    cft* self,RTIBool deletePointers);

NDDSUSERDllExport
void cft_finalize_w_params(
    cft* self,
    const struct DDS_TypeDeallocationParams_t * deallocParams);

NDDSUSERDllExport
void cft_finalize_optional_members(
    cft* self, RTIBool deletePointers);  

NDDSUSERDllExport
RTIBool cft_copy(
    cft* dst,
    const cft* src);

#if (defined(RTI_WIN32) || defined (RTI_WINCE)) && defined(NDDS_USER_DLL_EXPORT)
/* If the code is building on Windows, stop exporting symbols.
*/
#undef NDDSUSERDllExport
#define NDDSUSERDllExport
#endif

#endif /* cft */

